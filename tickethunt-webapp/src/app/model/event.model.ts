import { FileHandle } from "./file-handle.model";

export type EventData = {
    eventId?: String,
    email?: String,
    eventName?: String,
    date?: String,
    time?: String,
    venue?: String,
    organizerName?: String,
    totalSeat?: Number,
    eventType?: string,
    // price?: Number,
    // image?: any,
}