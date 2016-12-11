//
//  RCTMyAlert.h
//  RNBindingSample
//
//  Created by 柴田幸輝 on 2016/12/10.
//  Copyright © 2016年 Facebook. All rights reserved.
//

#import <UIKit/UIKit.h>

#import <RCTBridgeModule.h>
#import <RCTInvalidating.h>

typedef NS_ENUM(NSInteger, RCTMyAlertViewStyle) {
    RCTMyAlertViewStyleDefault = 0,
    RCTMyAlertViewStylePlainTextInput
};


@interface RCTMyAlert : NSObject <RCTBridgeModule, RCTInvalidating>

@end
