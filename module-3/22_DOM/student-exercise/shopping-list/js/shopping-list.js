// add pageTitle
const pageTitle = 'My Shopping List';
const groceries = ['rice', 'salmon', 'beans', 'chicken', 'adobo seasoning', 'flank steak', 'broccoli', 'red bell peppers', 'black pepper', 'yams'];
// add groceries

/**
 * This function will get a reference to the title and set its text to the value
 * of the pageTitle variable that was set above.
 */
function setPageTitle() {
  document.querySelector('#title').innerText = pageTitle;
}

/**
 * This function will loop over the array of groceries that was set above and add them to the DOM.
 */
function displayGroceries() {
  let groceryList = document.querySelector('#groceries');

  let domFragment = groceries.reduce((fragment, item) => {
    let li = document.createElement('li')
    li.appendChild(document.createTextNode(item))
    fragment.appendChild(li);
    return fragment;
  }, new DocumentFragment())

  groceryList.appendChild(domFragment);
}

/**
 * This function will be called when the button is clicked. You will need to get a reference
 * to every list item and add the class completed to each one
 */
function markCompleted() {
  let groceryList = [...document.querySelectorAll('#groceries li')];
  groceryList.map(item => item.classList.add('completed'));
}

setPageTitle();

displayGroceries();

// Don't worry too much about what is going on here, we will cover this when we discuss events.
document.addEventListener('DOMContentLoaded', () => {
  // When the DOM Content has loaded attach a click listener to the button
  const button = document.querySelector('.btn');
  button.addEventListener('click', markCompleted);
});
