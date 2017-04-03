import { JmsexpPage } from './app.po';

describe('jmsexp App', () => {
  let page: JmsexpPage;

  beforeEach(() => {
    page = new JmsexpPage();
  });

  it('should display message saying app works', () => {
    page.navigateTo();
    expect(page.getParagraphText()).toEqual('app works!');
  });
});
