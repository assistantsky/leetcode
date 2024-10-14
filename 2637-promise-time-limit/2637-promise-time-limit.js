function asyncOperation(resolveValue) {
  return new Promise((resolve) => {
    const delay = Math.floor(Math.random() * 3000); // Random delay from 0 to 2999 ms
    setTimeout(() => resolve(resolveValue), delay);
  });
}

// The `timeLimit` function wraps around our `asyncOperation`.
const timeLimit = (fn, t) => (...args) => 
  Promise.race([
    fn(...args),
    new Promise((_, reject) => setTimeout(() => reject('Time Limit Exceeded'), t))
  ]);

// Let's create a time-limited version of our `asyncOperation` with a 2000 ms limit.
const limitedAsyncOperation = timeLimit(asyncOperation, 2000);

// Call the time-limited asynchronous function with a sample resolve value.
limitedAsyncOperation('Sample resolve value')
  .then(result => console.log(`Operation successful: ${result}`))
  .catch(error => console.log(`Operation failed: ${error}`));