
//: Playground - noun: a place where people can play

import Cocoa

print("EXERCISE # 1\n--------------------------------------------")

let MAX_SIZE = 101
let input = [2, 1, 2, 101, 4, 95, 3, 250, 4, 1, 2, 2, 7, 98, 123, 99]
var instances = [Int: String]()
for nextInput in input {
    let nextKey = nextInput < 100 ? nextInput : 100
    var str = instances[nextKey]
    str = str == nil ? "x" : str! + "x"
    instances[nextKey] = str
}

for index in 1...100 {
    print("\(index < 100 ? String(index) : "99+") | \(instances[index] == nil ? "" : instances[index]!)")
}
print("--------------------------------------------\n")

print("EXERCISE # 2\n--------------------------------------------")
let input2 = [1, 6, 3, 2, 5, 5, 7, 8, 4, 8, 2, 5, 9, 9, 1];
var output2 = "";
var instances2 = [Int:[Int]]()
for nextInput in input2 {
    if(instances2[nextInput] == nil) {
        let numbers: [Int] = [nextInput]
        instances2[nextInput] = numbers
    }
    else {
        instances2[nextInput]?.append(nextInput)
    }
}

//We must deal with the number # 5 before we continue
//or we will end up with the wrong output
//because an extra copy has been added to the list.
if let total2 = instances2[5]?.count {
    if(total2 > 1) {
        instances2[5]?.remove(at: total2 - 1)
    }
}

for nextInput in input2 {
    let answer = 10 - nextInput
    if(instances2[answer] != nil) {
        for nextNumber in instances2[answer]! {
            print("(\(nextInput), \(nextNumber))")
        }
    }
}

print("--------------------------------------------\n")

print("EXERCISE # 3\n--------------------------------------------")

func pad(string : String, toSize: Int) -> String {
    var padded = string
    for _ in 0..<(toSize - string.characters.count) {
        padded = "0" + padded
    }
    return padded
}

var input3 = "abcd";
let size3 = Decimal(input3.count)
let permutations = pow(size3, 2) - 1
let result = NSDecimalNumber(decimal: permutations)
var iterations = Int(truncating: result)%2 == 0 ? Int(truncating: result) + 1 : Int(truncating: result);
let characters = Array(input3)

for i in 1...iterations {
    let str = String(i, radix: 2)
    let binary = pad(string: str, toSize: input3.count)
    
    var nextCombo = ""
    var j = str.count - 1
    for nextBit in str.characters {
        let nextString = String(nextBit)
        if let nextValue = Int(nextString) {
            if(nextValue == 1) {
                var nextCharacter = characters[j]
                nextCombo = String(nextCharacter) + nextCombo
            }
        }
        j = j - 1
    }

    print(nextCombo)
}

print("--------------------------------------------\n")

