// import axios from "axios"

export async function getUserRewardList(userId) {
    // STUB
    console.log(userId)
    return new Promise(resolve => {
        setTimeout(() => {
            resolve([{
                id: 1,
                eventId: 1,
                avatarUrl: 'https://i.pinimg.com/originals/66/08/3d/66083da7a43e425d655c151cb5baab11.jpg',
                priority: 1
            }, {
                id: 4,
                eventId: 2,
                avatarUrl: 'https://raw.githubusercontent.com/Ashwinvalento/cartoon-avatar/master/lib/images/male/45.png',
                priority: 3
            }])
        }, 100)
    })
}

export async function getEventRewardList(eventId) {
    // STUB
    console.log(eventId)
    return new Promise(resolve => {
        setTimeout(() => {
            resolve([{
                id: 7,
                eventId: 3,
                avatarUrl: 'https://i.pinimg.com/originals/66/08/3d/66083da7a43e425d655c151cb5baab11.jpg',
                priority: 1
            }, {
                id: 8,
                eventId: 3,
                avatarUrl: 'https://i.pinimg.com/originals/66/08/3d/66083da7a43e425d655c151cb5baab11.jpg',
                priority: 2
            },  {
                id: 9,
                eventId: 3,
                avatarUrl: 'https://i.pinimg.com/originals/66/08/3d/66083da7a43e425d655c151cb5baab11.jpg',
                priority: 3
            }])
        }, 100)
    })
}
