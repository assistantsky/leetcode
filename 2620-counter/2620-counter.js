var createCounter = function(n) {

    return function() {
        let m = n;
        n++
        return m;
    };
};