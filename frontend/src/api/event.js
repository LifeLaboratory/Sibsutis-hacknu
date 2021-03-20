// import axios from "axios"

export async function getEventsByFilter(filterName) {
    // STUB
    return [{
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
    }]
}

export async function getEvent(id) {
    // STUB
    return {
        id,
        name: 'stubEventName',
        description: 'lorem ipsum',
        ownerId: -1,
        eventType: 'IT'
    }
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
    return {
        id: 1,
        name: name,
        description: description,
        ownerId: ownerId,
        eventType: 'IT'
    }
}

export async function updateEventStatus({eventId, completedStatus}) {
    // STUB
    console.log(completedStatus)
    return {
        id: eventId,
        name: 'stubEventName',
        description: 'lorem ipsum',
        ownerId: -1,
        eventType: 'IT'
    }
}

export async function joinEvent({eventId, userId}) {
    // STUB
    console.log(userId)
    return {
        id: eventId,
        name: 'stubEventName',
        description: 'lorem ipsum',
        ownerId: -1,
        eventType: 'IT'
    }
}
