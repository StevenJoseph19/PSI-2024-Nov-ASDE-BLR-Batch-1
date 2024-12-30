import type { NextConfig } from 'next';
import path from 'path';

const nextConfig: NextConfig = {
  reactStrictMode: true,
  output: 'export', // Enables static export
  webpack(config, { isServer }) {
    // Exclude test files from the production build
    config.module.rules.push({
      test: /\.(test|spec)\.(js|ts|tsx)$/, // Match .test.js, .test.ts, .test.tsx files
      use: 'ignore-loader', // Use 'ignore-loader' to prevent Jest files from being bundled
      exclude: /node_modules/, // Exclude node_modules as well
    });

    // Ensure that test files are not treated as pages by Next.js
    config.resolve.alias['@pages'] = path.join(__dirname, 'pages');
    config.resolve.alias['@pages/test'] = path.join(__dirname, 'pages/test');

    return config;
  },
  // You can optionally disable page extensions for files that should not be treated as pages
  pageExtensions: ['tsx', 'ts', 'jsx', 'js'], // Exclude `.test.tsx` from being treated as pages
};

export default nextConfig;
