import AuthenticationService from '@/services/AuthenticationService.js'

describe('AuthenticationService.js', () => {
  it('test if authenticateUser in AuthenticationService is a function', () => {
    expect(typeof AuthenticationService.authenticateUser).toBe('function')
  })
})  

//npm run test:unit