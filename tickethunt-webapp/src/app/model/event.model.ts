import { FileHandle } from "./file-handle.model";

export type EventData = {
    eventId?: String, 
    email?:String,
    eventName?: String,
    date?: String, 
    time?: String, 
    venue?: String, 
    image?: any,
    organizerName?: String, 
    totalSeat?: Number,
    // price?: Number,
}