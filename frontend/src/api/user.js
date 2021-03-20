// import axios from "axios"

export async function getUserProfile(userId) {
    // STUB
    return new Promise(resolve => {
        setTimeout(() => resolve({
            id: userId,
            name: 'stubUserName',
            surname: 'stubUserSurname',
            avatarUrl: 'https://raw.githubusercontent.com/Ashwinvalento/cartoon-avatar/master/lib/images/male/45.png',
        }), 100)
    })
}

export async function authUser(data) {
    // STUB
    return new Promise(resolve => {
        setTimeout(() => resolve(data), 100)
    })
}

export async function registerUser(data) {
    // STUB
    return new Promise(resolve => {
        setTimeout(() => resolve(data), 100)
    })
}
