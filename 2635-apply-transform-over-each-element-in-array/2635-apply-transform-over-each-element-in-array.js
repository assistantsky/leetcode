   var map = function(arr, fn) {

        returnedArray = []

        for (let i =0; i<arr.length; i++){

            returnedArray[i] = fn(arr[i], i)

        }

        return returnedArray

    };
    
