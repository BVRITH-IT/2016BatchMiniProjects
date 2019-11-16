import cv2

face = cv2.CascadeClassifier('haarcascade_frontalface_default.xml')
filename='C:/Users/Administrator.WINCTRL-QTJCOLQ/Desktop/filters/images/1.JPG'
img=cv2.imread(filename)
gray=cv2.cvtColor(img,cv2.COLOR_BGR2GRAY)
fl=face.detectMultiScale(gray,1.09,7)
ey=face.detectMultiScale(gray,1.09,7)
hat=cv2.imread('C:/Users/Administrator.WINCTRL-QTJCOLQ/Desktop/filters/Filters/hat.png')
glass=cv2.imread('C:/Users/Administrator.WINCTRL-QTJCOLQ/Desktop/filters/Filters/glasses.png')
def put_hat(hat, fc, x, y, w, h):
    face_width = w
    face_height = h
    hat_width = face_width + 1
    hat_height = int(0.50 * face_height) + 1
    hat = cv2.resize(hat, (hat_width, hat_height))

    for i in range(hat_height):
        for j in range(hat_width):
            for k in range(3):
                if hat[i][j][k] < 235:
                    fc[y + i - int(0.40 * face_height)][x + j][k] = hat[i][j][k]
    return fc


def put_glass(glass, fc, x, y, w, h):
    face_width = w
    face_height = h

    hat_width = face_width + 1
    hat_height = int(0.50 * face_height) + 1

    glass = cv2.resize(glass, (hat_width, hat_height))

    for i in range(hat_height):
        for j in range(hat_width):
            for k in range(3):
                if glass[i][j][k] < 235:
                    fc[y + i - int(-0.20 * face_height)][x + j][k] = glass[i][j][k]
    return fc
for (x, y, w, h) in fl:
    frame = put_hat(hat, img, x, y, w, h)
for (x, y, w, h) in ey:
    frame=put_glass(glass,img, x, y, w, h)
    # img = cv2.rectangle(img, (x, y), (x + w, y + h), (255, 0, 0), 2)
cv2.imshow('images',frame)
cv2.waitKey(8000)& 0xff
cv2.destroyAllWindows()
