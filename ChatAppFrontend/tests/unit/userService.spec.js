import UserService from '@/services/UserService.js'

describe('UserService.js', () => {
  it('test if getUsers in UserService is a function', () => {
    expect(typeof UserService.getUsers).toBe('function')
  })

  it('should return admin username', async () => {
    const response = await UserService.getUsers();
    expect(response[0].username).toBe("admin")
  });

  it('should return user username', async () => {
    const response = await UserService.getUsers();
    expect(response[1].username).toBe("user")
  });
})  