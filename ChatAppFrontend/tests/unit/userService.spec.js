import UserService from '@/services/UserService.js'

jest.mock("axios");

describe('UserService.js', () => {
  it('test if getUsers in UserService is a function', () => {
    expect(typeof UserService.getUsers).toBe('function')
  })
})  

//npm run test:unit