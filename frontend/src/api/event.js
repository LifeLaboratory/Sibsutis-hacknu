// import axios from "axios"

export async function getEventsByFilter(filterName) {
    // STUB
    return new Promise(resolve => {
        setTimeout(() => resolve([{
            id: 1,
            name: 'stubEventName1',
            description: 'lorem ipsum',
            ownerId: -1,
            eventType: filterName
        }, {
            id: 2,
            name: 'stubEventName2',
            description: 'lorem ipsum dolor',
            ownerId: -2,
            eventType: filterName
        }]), 100)
    })
}

export async function getEvent(eventId) {
    // STUB
    return new Promise(resolve => {
        setTimeout(() => resolve({
            id: eventId,
            name: 'stubEventName',
            description: 'lorem ipsum',
            ownerId: -1,
            eventType: 'IT'
        }), 100)
    })
}

export async function createNewEvent({name, description, ownerId, rewardImageArray}) {
    const formData = new FormData()
    rewardImageArray.forEach((image, index) => {
        formData.append(`reward${index}`, image)
    })

    // headers: {
    //     'Content-Type': 'multipart/form-data'
    // }

    // STUB
    return new Promise(resolve => {
        setTimeout(() => resolve({
            id: 1,
            name: name,
            description: description,
            ownerId: ownerId,
            eventType: 'IT'
        }), 100)
    })
}

export async function updateEventStatus({eventId, completedStatus}) {
    // STUB
    console.log(completedStatus)
    return new Promise(resolve => {
        setTimeout(() => resolve({
            id: eventId,
            name: 'stubEventName',
            description: 'lorem ipsum',
            ownerId: -1,
            eventType: 'IT'
        }), 100)
    })
}

export async function joinEvent({eventId, userId}) {
    // STUB
    console.log(userId)
    return new Promise(resolve => {
        setTimeout(() => resolve({
            id: eventId,
            name: 'stubEventName',
            description: 'lorem ipsum',
            ownerId: -1,
            eventType: 'IT'
        }), 100)
    })
}
