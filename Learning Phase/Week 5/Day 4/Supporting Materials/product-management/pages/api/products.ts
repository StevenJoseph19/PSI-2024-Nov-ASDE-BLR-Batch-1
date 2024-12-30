import { NextApiRequest, NextApiResponse } from 'next';

const products = [{ id: 1, name: 'Sample Product', price: '10.00' }];

export default function handler(req: NextApiRequest, res: NextApiResponse) {
  if (req.method === 'GET') {
    res.status(200).json(products);
  } else if (req.method === 'POST') {
    const { name, price } = req.body;
    const newProduct = { id: Date.now(), name, price };
    products.push(newProduct);
    res.status(201).json(newProduct);
  } else {
    res.status(405).json({ error: 'Method Not Allowed' });
  }
}
