#import <UIKit/UIKit.h>
#import "UIView+React.h"

@interface RCTDatePicker : UIDatePicker

@property (nonatomic, copy) RCTBubblingEventBlock onMyChange;

@end
