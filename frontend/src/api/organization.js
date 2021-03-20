// import axios from "axios"

export function getOrganizationProfile(organizationId, ownerId) {
    // STUB
    return new Promise(resolve => {
        setTimeout(() => {
            if (organizationId) {
                resolve({
                    organizationId,
                    name: 'stubOrgName',
                    avatarUrl: 'https://i.pinimg.com/originals/66/08/3d/66083da7a43e425d655c151cb5baab11.jpg',
                    ownerId: '1'
                })
            } else if (ownerId) {
                resolve({
                    id: -1,
                    name: 'stubOrgName',
                    avatarUrl: 'https://i.pinimg.com/originals/66/08/3d/66083da7a43e425d655c151cb5baab11.jpg',
                    ownerId
                })
            }
        }, 100)
    })

}

export function authOrganization(data) {
    // STUB
    return new Promise(resolve => {
        setTimeout(() => resolve(data), 100)
    })
}

export async function registerOrganization(data) {
    // STUB
    return new Promise(resolve => {
        setTimeout(() => resolve(data), 100)
    })
}
