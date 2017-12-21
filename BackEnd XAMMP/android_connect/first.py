def some_func():
    text_file = open("1.txt", "r")
    x = text_file.read()
    if x == "1":
        print "Hello"
    elif x == "2":
        print "Where"
    elif x == "3":
        print "You"
    elif x == "4":
        print "Home"
