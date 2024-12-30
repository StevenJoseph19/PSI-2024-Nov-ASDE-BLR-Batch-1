import React, { useState, useEffect } from 'react';
import ProductForm from '../components/ProductForm';
import ProductList from '../components/ProductList';

interface Product {
  id: number;
  name: string;
  price: string;
}

const Home: React.FC = () => {
  const [products, setProducts] = useState<Product[]>([]);

  // Fetch existing products on initial load
  useEffect(() => {
    fetch('/api/products')
      .then((res) => res.json())
      .then((data) => setProducts(data));
  }, []);

  const handleAddProduct = (product: Product) => {
    setProducts([...products, product]);
  };

  return (
    <div>
      <h1>Product Management</h1>
      {/* Add New Product */}
      <ProductForm onAddProduct={handleAddProduct} />

      {/* List Existing Products */}
      <ProductList products={products} />
    </div>
  );
};

export default Home;
