import type { HostComponent, ViewProps } from 'react-native';
import type { BubblingEventHandler } from 'react-native/Libraries/Types/CodegenTypes';
import codegenNativeComponent from 'react-native/Libraries/Utilities/codegenNativeComponent';

type SurfaceViewUrlLoadedEvent = {
    result: 'success' | 'error';
};

export interface NativeProps extends ViewProps {
    videoUrl?: string;
    onScriptLoaded?: BubblingEventHandler<SurfaceViewUrlLoadedEvent> | null;
}

export default codegenNativeComponent<NativeProps>(
    'SurfaceView',
) as HostComponent<NativeProps>;