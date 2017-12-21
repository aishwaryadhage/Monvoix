import numpy as np
from PIL import Image
import cv2
import subprocess
import sys
import colorsys
import matplotlib
import imutils

img = cv2.imread('/Applications/XAMPP/xamppfiles/htdocs/android_connect/0.jpeg')
hsv = cv2.cvtColor(img, cv2.COLOR_BGR2HSV)
cv2.imwrite('/Applications/XAMPP/xamppfiles/htdocs/android_connect/hsv.jpeg', hsv)

kernel = np.ones((5,5),np.float32)/25
cv2.imwrite('hsv.jpg', hsv)
kernel = np.ones((5,5),np.float32)/25
blurImg = cv2.medianBlur(hsv,1)
if not blurImg is None and len(blurImg.shape) == 3 and blurImg.shape[2] == 3:
    blue_img, green_img, red_img = cv2.split(blurImg)  # extracting red channel
    rbin, thresh1 = cv2.threshold(red_img, 58, 255, cv2.THRESH_BINARY_INV)  # thresholding

else:
    if blurImg is None:
        print ("Sorry the image path was not valid")
    else:
        print ("Sorry the Image was not loaded in BGR; 3-channel format")
#ret,thresh1 = cv2.threshold(blurImg,127,255,cv2.THRESH_BINARY_INV)
edges = cv2.Canny(thresh1,40,40)
kernel2 = np.ones((5,5),np.uint8)
skinMask = cv2.dilate(edges,kernel2, iterations = 1)
cv2.imwrite('/Applications/XAMPP/xamppfiles/htdocs/android_connect/frame1.jpeg', skinMask)
size = 30, 30
im = Image.open('/Applications/XAMPP/xamppfiles/htdocs/android_connect/frame1.jpeg')
im.thumbnail(size, Image.ANTIALIAS)
im.save('/Applications/XAMPP/xamppfiles/htdocs/android_connect/image_capture.jpeg')

np.set_printoptions(threshold = np.inf)
im = Image.open('/Applications/XAMPP/xamppfiles/htdocs/android_connect/image_capture.jpeg')

array = []
a = np.array(im.getdata())


text_file = open("/Applications/XAMPP/xamppfiles/htdocs/android_connect/CapturedImgMatrix.txt", "w")
count = 1
count1 = count + 3
text_file.write('%s '%count1)
for i in a:
    x = a[i]
    text_file.write('%s:%d '%(count, x))
    count = count + 1

text_file.write('\n')

text_file.close()

#testFile = sys.argv[1]
#modelFile = sys.argv[2]
#outputFile = sys.argv[3] # This file stores the predicted class label. This is your final result.

predictCommand = '/usr/local/bin/svm-predict ' + '/Applications/XAMPP/htdocs/android_connect/CapturedImgMatrix.txt' + ' ' + '/Applications/XAMPP/htdocs/android_connect/inputimage.txt.model' + ' ' + '/Applications/XAMPP/htdocs/android_connect/recognizedGesture.txt'
#print predictCommand

try:
	predictOutput = subprocess.check_output(predictCommand, shell=True) # This stores the accuracy
	#print predictOutput
except subprocess.CalledProcessError as grepexc:
	print " "
# Your test data will have only one row since the user will provide only one gesture as input at one time. So read only the first line of the outputFile
predictedClass=open('/Applications/XAMPP/htdocs/android_connect/recognizedGesture.txt').readline().rstrip()
#print predictedClass


#first.some_func()


if predictedClass == "1":
    print "Hello"
elif predictedClass == "2":
    print "Where"
elif predictedClass == "3":
    print "You"
elif predictedClass == "4":
    print "Home"
