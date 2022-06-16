module.exports = {
  preset: '@vue/cli-plugin-unit-jest',  
  moduleFileExtensions: [
    'js',
    'jsx',
    'json',
    'vue',
  ],
  transformIgnorePatterns: [
    '<rootDir>/(node_modules)/',
  ],
  moduleNameMapper: {
    '^@/(.*)$': '<rootDir>/src/$1',
  },
}