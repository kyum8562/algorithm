# Sorting (0) - Basic Sort, O(n^2)

arr = [3, 1, 2, 5, 4]
temp = 0

for i in range(len(arr)-1):
    if arr[i] > arr[i+1]:
        temp = arr[i+1]  # swap
        arr[i+1] = arr[i]
        arr[i] = temp

print(arr)



# Sorting (1) - Bubble Sort, O(n^2)
