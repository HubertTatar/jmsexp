export class Bug {
  constructor(
    public id: number,
    public version: number,
    public title: string,
    public status: number,
    public serverity: number,
    public description: string,
    public createdBy: string,
    public createdDate: number,
    public modificationDate: number,
    public updatedBy?: string,
) {}
}
