// import axios from "axios"

export function getOrganizationProfile(organizationId, ownerId) {
    // STUB
    if (organizationId) {
        return {
            organizationId,
            name: 'stubOrgName',
            avatarUrl: 'https://i.pinimg.com/originals/66/08/3d/66083da7a43e425d655c151cb5baab11.jpg',
            ownerId: '1'
        }
    } else if (ownerId) {
        return {
            id: -1,
            name: 'stubOrgName',
            avatarUrl: 'https://i.pinimg.com/originals/66/08/3d/66083da7a43e425d655c151cb5baab11.jpg',
            ownerId
        }
    }
}

export function authOrganization(data) {
    // STUB
    return data
}

export async function registerOrganization(data) {
    // STUB
    return data
}
