#import "MyDatePicker.h"

@implementation MyDatePicker

- (instancetype)initWithFrame:(CGRect)frame {
  if ((self = [super initWithFrame:frame])) {
    [self addTarget:self action:@selector(didChange:)
   forControlEvents:UIControlEventValueChanged];
  }
  return self;
}

- (void)didChange:(MyDatePicker*)sender {
  if (sender.onMyChange) {
    sender.onMyChange(@{ @"myChangeDateEvent": @(self.date.timeIntervalSince1970 * 1000.0) });
  }
}

@end
