import UserService from '@/services/UserService.js'
import mockAxios from 'axios'

jest.mock("axios")
const data = [{ username: "admin"}, { username: "user"}]
mockAxios.get.mockResolvedValue({data})

describe('UserService.js', () => {
  afterEach(jest.clearAllMocks)

  it('test if getUsers in UserService is a function', () => {
    expect(typeof UserService.getUsers).toBe('function')
  })

  it('should return admin username', async () => {
    const response = await UserService.getUsers()
    expect(response[0].username).toBe("admin")
    expect(mockAxios.get).toHaveBeenCalledTimes(1)
  })

  it('should return user username', async () => {
    const response = await UserService.getUsers()
    expect(response[1].username).toBe("user")
    expect(mockAxios.get).toHaveBeenCalledTimes(1)
  })
})  