# vsc python 실행 : ctrl + shift + b

####### array 예제 #######


# arr = range(10)
# arr = [0, 1, 2, 3, 4, 5, 6, 7, 8, 9]
# array 출력하기


# print("Original arr[] : ", arr)
# #
# print("처음부터 끝까지 두 칸씩 출력", arr[::2])
# #
# print("index1부터 끝까지 두 칸씩 출력", arr[1::2])
# #
# print("처음부터 끝까지 -1칸 간격으로 출력(역순)", arr[::-1])
# #
# print("처음부터 끝까지 -2칸 간격으로 출력", arr[::-2])
# #
# print("index3부터 끝까지 -1칸 간격으로 출력", arr[3::-1])
# #
# print("index1부터 idx6까지 두 칸 간격으로 출력", arr[1:6:2])


####### 난수 출력하기 예제 #######


# 랜덤 모듈 선언
import random                      # 랜덤 모듈
import string                      # 스트링 모듈

# 난수 생성                        # randomrange(시작숫자, 끝숫자 +1)
num1 = random.randrange(1, 51)     # 1~50 난수 생성하기
num2 = random.randrange(1, 51, 2)  # 1~50 중 홀수 난수 생성하기
num3 = random.randrange(2, 51, 2)  # 2~50 중 짝수 난수 생성하기

ary1 = [1, 2, 3, 4, 5]
random.shuffle(ary1)               # 리스트 셔플

aryChoice = random.choice(ary1)    # 리스트에서 랜덤으로 하나 선택

pw1 = "".join([random.choice(string.ascii_uppercase)
              for _ in range(10)])  # 대문자 난수 10개 출력
pw2 = "".join([random.choice(string.ascii_lowercase)
              for _ in range(10)])  # 소문자
pw3 = "".join([random.choice(string.ascii_letters)
              for _ in range(10)])   # 대+소문자

list_a = []                        # 중복되지 않은 값만 리스트에 넣어주기
num4 = random.randrange(0, 10)
for i in range(10):
    while num4 in list_a:
        num4 = random.randrange(0, 10)
    list_a.append(num4)


# 출력
print(num1, num2, num3)
print(ary1, aryChoice)
print(pw1)
print(pw2)
print(pw3)
print(list_a)
