var nums = [10,30,20,6,7];
nums.sort(function(a,b){return a-b;});

nums.sort(compare);

function compare(a, b) {
    return a - b;
}
