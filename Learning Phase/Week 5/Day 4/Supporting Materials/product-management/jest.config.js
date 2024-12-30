module.exports = {
  preset: 'ts-jest',
  testEnvironment: 'jest-environment-jsdom',
  globals: {
    'ts-jest': {
      tsconfig: 'tsconfig.dev.json', // Point to the test-specific tsconfig
    },
  },
  testMatch: ['<rootDir>/__tests__/**/*.{js,jsx,ts,tsx}'], // Ensure Jest picks up tests from __tests__ folder
  transform: {
    '^.+\\.(ts|tsx)$': 'ts-jest',
  },
  setupFilesAfterEnv: ['@testing-library/jest-dom', '<rootDir>/jest.setup.ts'], // Correct the module path
};
