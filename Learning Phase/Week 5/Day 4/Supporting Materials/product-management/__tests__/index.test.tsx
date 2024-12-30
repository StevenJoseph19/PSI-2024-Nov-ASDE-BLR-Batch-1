import React from 'react';
import { render, screen, fireEvent, waitFor } from '@testing-library/react';
import Home from '../pages/index';

// Mock the fetch API
global.fetch = jest.fn(() =>
  Promise.resolve({
    json: () =>
      Promise.resolve([
        { id: 1, name: 'Product 1', price: '10.00' },
        { id: 2, name: 'Product 2', price: '20.00' },
      ]),
  })
) as jest.Mock;

describe('Home Component', () => {
  beforeEach(() => {
    jest.clearAllMocks();
  });

  it('fetches and displays products on load', async () => {
    render(<Home />);

    // Wait for the products to appear
    await waitFor(() => {
      expect(screen.getByText(/product 1/i)).toBeInTheDocument();
      expect(screen.getByText(/10.00/i)).toBeInTheDocument();
    });

    expect(fetch).toHaveBeenCalledTimes(1);
    expect(fetch).toHaveBeenCalledWith('/api/products');
  });

  it('adds a new product to the list when form is submitted', async () => {
    render(<Home />);

    // Wait for initial products
    await waitFor(() => {
      expect(screen.getByText(/product 1/i)).toBeInTheDocument();
    });

    // Mock POST response
    global.fetch = jest.fn(() =>
      Promise.resolve({
        json: () =>
          Promise.resolve({
            id: 3,
            name: 'Product 3',
            price: '30.00',
          }),
      })
    ) as jest.Mock;

    // Fill out and submit the form
    fireEvent.change(screen.getByPlaceholderText(/name/i), {
      target: { value: 'Product 3' },
    });
    fireEvent.change(screen.getByPlaceholderText(/price/i), {
      target: { value: '30.00' },
    });
    fireEvent.click(screen.getByText(/add product/i));

    // Wait for the new product to appear in the list
    await waitFor(() => {
      expect(screen.getByText(/product 3/i)).toBeInTheDocument();
      expect(screen.getByText(/30.00/i)).toBeInTheDocument();
    });
  });
});
