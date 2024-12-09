self.addEventListener('install', (event) => {
  event.waitUntil(
    caches.open('travel-blog-cache-v1').then((cache) => {
      return cache.addAll([
        '/',
        '/index.html',
        '/styles.css',
        '/app.js',
        'https://maps.googleapis.com/maps/api/js?key=YOUR_API_KEY&callback=initMap',
      ]);
    })
  );
});

self.addEventListener('fetch', (event) => {
  event.respondWith(
    caches.match(event.request).then((response) => {
      return response || fetch(event.request);
    })
  );
});
