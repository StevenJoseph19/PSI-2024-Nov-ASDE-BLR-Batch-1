document.querySelector('form').addEventListener('submit', function (event) {
  event.preventDefault();

  // Get form data
  const name = document.getElementById('name').value;
  const email = document.getElementById('email').value;
  const travelMethod = document.getElementById('travel-method').value;

  // Save data to local storage
  localStorage.setItem('name', name);
  localStorage.setItem('email', email);
  localStorage.setItem('travelMethod', travelMethod);

  alert('Form data saved locally!');
});

document.getElementById('load-data').addEventListener('click', function () {
  // Get data from local storage
  const name = localStorage.getItem('name');
  const email = localStorage.getItem('email');
  const travelMethod = localStorage.getItem('travelMethod');

  // Display the saved data
  const savedDataDiv = document.getElementById('saved-data');
  savedDataDiv.innerHTML = `<p>Name: ${name}</p><p>Email: ${email}</p><p>Preferred Travel Method: ${travelMethod}</p>`;
});

if ('serviceWorker' in navigator) {
  window.addEventListener('load', () => {
    navigator.serviceWorker.register('/service-worker.js').then(
      (registration) => {
        console.log(
          'Service Worker registered with scope:',
          registration.scope
        );
      },
      (err) => {
        console.log('Service Worker registration failed:', err);
      }
    );
  });
}
