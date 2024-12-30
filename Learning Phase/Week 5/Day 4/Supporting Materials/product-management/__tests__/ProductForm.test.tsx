import { render, screen, fireEvent, waitFor } from '@testing-library/react';
import ProductForm from '../components/ProductForm';
import '@testing-library/jest-dom';

// Mock fetch globally
global.fetch = jest.fn().mockResolvedValue({
  json: jest
    .fn()
    .mockResolvedValue({ id: 1, name: 'Product 3', price: '30.00' }),
});

test('submits new product', async () => {
  const handleAddProduct = jest.fn();
  render(<ProductForm onAddProduct={handleAddProduct} />);

  fireEvent.change(screen.getByPlaceholderText(/Name/i), {
    target: { value: 'Product 3' },
  });
  fireEvent.change(screen.getByPlaceholderText(/Price/i), {
    target: { value: '30.00' },
  });
  fireEvent.click(screen.getByText(/Add Product/i));

  await waitFor(() => {
    expect(handleAddProduct).toHaveBeenCalledWith({
      id: 1,
      name: 'Product 3',
      price: '30.00',
    });
  });
});
