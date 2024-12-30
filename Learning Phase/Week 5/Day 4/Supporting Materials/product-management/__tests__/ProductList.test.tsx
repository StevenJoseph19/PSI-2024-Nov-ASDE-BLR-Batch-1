import { render, screen } from '@testing-library/react';
import ProductList from '../components/ProductList';
import '@testing-library/jest-dom';

describe('ProductList Component', () => {
  it('renders a list of products', () => {
    const products = [
      { id: 1, name: 'Product 1', price: '10.00' },
      { id: 2, name: 'Product 2', price: '20.00' },
    ];

    render(<ProductList products={products} />);

    // Check if the products are rendered
    expect(screen.getByText(/product 1/i)).toBeInTheDocument();
    expect(screen.getByText(/10.00/i)).toBeInTheDocument();
    expect(screen.getByText(/product 2/i)).toBeInTheDocument();
    expect(screen.getByText(/20.00/i)).toBeInTheDocument();
  });

  it('matches snapshot', () => {
    const products = [
      { id: 1, name: 'Product 1', price: '10.00' },
      { id: 2, name: 'Product 2', price: '20.00' },
    ];
    const { asFragment } = render(<ProductList products={products} />);
    expect(asFragment()).toMatchSnapshot();
  });
});
