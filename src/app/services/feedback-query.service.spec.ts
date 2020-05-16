import { TestBed } from '@angular/core/testing';

import { FeedbackQueryService } from './feedback-query.service';

describe('FeedbackQueryService', () => {
  let service: FeedbackQueryService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(FeedbackQueryService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
