const express = require('express');
const cors = require('cors');
const path = require('path');

const app = express();
const PORT = 3000;

// Middleware to parse JSON and enable CORS
app.use(express.json());
app.use(cors());

// Serve static files from the "html" directory
app.use(express.static(path.join(__dirname, 'html')));

// POST route to handle JSON data
app.post('/send-json', (req, res) => {
  console.log('Received JSON data:', req.body); // Logs the received data on the server

  // Respond with a success message and the received data
  res.json({
    message: 'Data received successfully!',
    receivedData: req.body, // Echo back the data received from the client
  });
});

// Start the server
app.listen(PORT, () => {
  console.log(`Server is running on http://localhost:${PORT}`);
});
