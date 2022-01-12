# random으로 주어진 num에 배열 a에 있는지 찾아보고 인덱스를 리턴해주자

# random 모듈 생성
import random

# arraySearch() 구조체 생성


def arraySearch(arrS, num, idx1):

    # 조건 및 출력
    for i in range(len(arrS)-1):
        if arrS[i] == num:
            idx1 = i
            return idx1

# arrayInsert() 구조체 생성


def arrayInsert(arrI, num, idx2):

    # 조건 및 출력
    if idx2 == len(arrI)-1:
        arrI.append(num)
        return arrI

    else:
        arrI.insert(idx2, num)
        return arrI

# arrayDelete() 구조체 생성


def arrayDelete(arrD, num):
    arrD.remove(num)


# main
if __name__ == "__main__":
    arrS = [1, 2, 3, 4, 5, 6]
    arrI = [1, 2, 3, 4, 5, 6]
    arrD = [1, 2, 3, 4, 5, 6]
    idx1 = 0
    # 삽입하려는 수(num) 난수(1~10 사이)로 생성
    num = random.randrange(1, 11)
    # 삽입하고자 하는 위치(idx2) 난수로 생성
    idx2 = random.randrange(1, len(arrI)-1)

    idx1 = arraySearch(arrS, num, idx1)
    arrayInsert(arrI, num, idx2)
    arrayDelete(arrD, num)

    print("arrS : ", arrS)
    print("arrI : ", arrI)
    print("arrD : ", arrD)
    print("num :", num)

    if idx1 == 0:
        print("num과 같은 수를 배열 arrS에서 찾지 못했습니다.")
    else:
        print("num과 같은 수는 배열 arrS의", idx1, "번 째에 있습니다.")
