import AuthenticationService from '@/services/AuthenticationService.js'

jest.mock("axios");

describe('AuthenticationService.js', () => {
  it('test if authenticateUser in AuthenticationService is a function', () => {
    expect(typeof AuthenticationService.authenticateUser).toBe('function')
  })
})  