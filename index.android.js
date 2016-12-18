/**
 * Sample React Native App
 * https://github.com/facebook/react-native
 * @flow
 */

import React, { Component } from 'react';
import {
  AppRegistry,
  StyleSheet,
  Text,
  View
} from 'react-native';

import URYSlider from './URYSlider'

export default class RNBindingSample extends Component {
  render() {
    return (
      <View>
        <URYSlider />
      </View>
    );
  }
}

AppRegistry.registerComponent('RNBindingSample', () => RNBindingSample);
