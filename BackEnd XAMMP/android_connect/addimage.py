import numpy as np
from PIL import Image
import cv2
import subprocess
import sys

img = cv2.imread('/Applications/XAMPP/xamppfiles/htdocs/android_connect/uploads/0.jpg',0)
kernel = np.ones((5,5),np.float32)/25
blurImg = cv2.blur(img,(40,40))
ret,thresh1 = cv2.threshold(blurImg,127,255,cv2.THRESH_BINARY_INV)
edges = cv2.Canny(thresh1,40,40)
kernel2 = np.ones((5,5),np.uint8)
skinMask = cv2.dilate(edges,kernel2, iterations = 10)
cv2.imwrite('/Applications/XAMPP/xamppfiles/htdocs/android_connect/frame1.png', skinMask)
size = 30, 30
im = Image.open('/Applications/XAMPP/xamppfiles/htdocs/android_connect/frame1.png')
im.thumbnail(size, Image.ANTIALIAS)
im.save('/Applications/XAMPP/xamppfiles/htdocs/android_connect/image_capture.jpg')

np.set_printoptions(threshold = np.inf)
im = Image.open('/Applications/XAMPP/xamppfiles/htdocs/android_connect/image_capture.jpg')

array = []
a = np.array(im.getdata())

gesture=open('/Applications/XAMPP/htdocs/android_connect/uploads/gesture.txt').readline().rstrip()
if(gesture=="Hello"):
	count1="1";
elif(gesture=="Where"):
	count1="2";
elif(gesture=="You"):
	count1="3";
elif(gesture=="Home"):
	count1="4";


text_file = open("/Applications/XAMPP/xamppfiles/htdocs/android_connect/newimage.txt", "a")
count = 1
text_file.write('%s '%count1)
for i in a:
    x = a[i]
    text_file.write('%s:%d '%(count, x))
    count = count + 1

text_file.write('\n')

text_file.close()
print "hi"

