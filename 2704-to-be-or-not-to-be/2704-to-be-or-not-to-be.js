var expect = function (val) {
  return {
    toBe: (value) => {
      if (value !== val) {
        throw new Error("Not Equal");
      } else {
        return true;
      }
    },
    notToBe: (value) => {
      if (value === val) {
        throw new Error("Equal");
      } else {
        return true;
      }
    },
  };
};
