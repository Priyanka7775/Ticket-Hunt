import { FileHandle } from "./file-handle.model";

export type EventData = {
    eventId?: String|null|undefined,
    email?: String,
    eventName?: String,
    date?: String,
    time?: String,
    venue?: String,
    organizerName?: String,
    totalSeat?: Number,
    eventType?: string,
    description?:string
    price?: Number,
    // image?: any,
    
}