import React from 'react';

type Product = { id: number; name: string; price: string };

const ProductList: React.FC<{ products: Product[] }> = ({ products }) => {
  return (
    <ul>
      {products.map((product) => (
        <li key={product.id}>
          {product.name} - ${product.price}
        </li>
      ))}
    </ul>
  );
};

export default ProductList;
