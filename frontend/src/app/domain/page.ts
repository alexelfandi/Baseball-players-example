import { Player } from './player';

export class Page {
    pageSize: number;
    pageNumber: number;
    content: Player[];
    totalElements: number;
    totalPages: number;
}
