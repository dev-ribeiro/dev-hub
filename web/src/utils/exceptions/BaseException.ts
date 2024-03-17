export abstract class BaseException {
  private _message: string;

  constructor(message: string) {
    this._message = message;
  }

  get message() {
    return this._message;
  }
}
