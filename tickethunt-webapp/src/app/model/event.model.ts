import { FileHandle } from "./file-handle.model";

export type EventData = {
    id?: String, 
    title?: String,
    date?: String, 
    time?: String, 
    venue?: String, 
    image?: FileHandle,
    organizer?: String, 
    seats?: Number,
    price?: Number,
}