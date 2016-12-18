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

import MySlider from './MySlider'

export default class RNBindingSample extends Component {
  render() {
    return (
      <View>
        <MySlider />
      </View>
    );
  }
}

AppRegistry.registerComponent('RNBindingSample', () => RNBindingSample);
