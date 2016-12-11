
#import <Foundation/Foundation.h>
#import "RCTBridgeModule.h"

@interface RCT_EXTERN_MODULE(MyLogSwift, NSObject)

RCT_EXTERN_METHOD(callFunc:(NSInteger *)typeParam dict:(NSDictionary*)dict findEvents:(RCTResponseSenderBlock)callback)

@end
