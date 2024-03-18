export class ResponseDTO<T> {
  numberOfElements: number;
  success: boolean;
  response: T;
}
