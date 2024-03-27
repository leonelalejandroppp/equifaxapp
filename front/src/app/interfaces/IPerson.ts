import { IAddress } from "./IAddress"

export interface IPerson {
    id: string
    name: string
    rut: string
    created: Date
    address: IAddress
}